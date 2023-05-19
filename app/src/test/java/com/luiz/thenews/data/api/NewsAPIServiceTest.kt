package com.luiz.thenews.data.api

import android.app.Service
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsAPIServiceTest {

    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("newresponse,json")
            val responseBody = service.getTopHeadlines("us", page = 1).body()
            val request = server.takeRequest()
            Truth.assertThat(responseBody).isNotNull()
            Truth.assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=388dac33e40b4d7fbe4366f807fd3269")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize(){
       runBlocking {
           enqueueMockResponse("newresponse,json")
           val responseBody = service.getTopHeadlines("us", page = 1).body()
           val articleList = responseBody!!.articles
           Truth.assertThat(articleList.size).isEqualTo(20)
       }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newresponse,json")
            val responseBody = service.getTopHeadlines("us", page = 1).body()
            val articleList = responseBody!!.articles
            val article = articleList[0]
            Truth.assertThat(article.author).isEqualTo("CNBC")
            Truth.assertThat(article.url).isEqualTo("https://news.google.com/rss/articles/CBMiRGh0dHBzOi8vd3d3LmNuYmMuY29tLzIwMjMvMDUvMTcvc3RvY2stbWFya2V0LXRvZGF5LWxpdmUtdXBkYXRlcy5odG1s0gFIaHR0cHM6Ly93d3cuY25iYy5jb20vYW1wLzIwMjMvMDUvMTcvc3RvY2stbWFya2V0LXRvZGF5LWxpdmUtdXBkYXRlcy5odG1s?oc=5")
            Truth.assertThat(article.publishedAt).isEqualTo("2023-05-18T14:30:00Z")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}