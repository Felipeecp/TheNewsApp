# TheNewsApp
Projeto desenvolvido para praticar desenvolvimento de aplicações android utilizando o padrão MVVM Clean Architecture


<img src="assets\theNews.gif" alt="Demonstração Aplicativo">


## Descrição do Projeto
Este é um aplicativo Android desenvolvido em Kotlin que consome a News API para exibir notícias e permite aos usuários salvar suas notícias favoritas. O aplicativo utiliza várias bibliotecas, como Retrofit para consumir a API, Room para salvar as notícias favoritas localmente, além de testes unitários usando MockWebServer, Truth e JUnit. Também são utilizados View Models, Navigation, Dagger Hilt, RecyclerView com DiffUtil e WebView para fornecer uma experiência de usuário eficiente e fluída.

## Requisitos
- Android Studio 4.0 ou superior
- Android SDK versão 21 ou superior
- Dispositivo Android com versão do sistema operacional compatível (API 21 ou superior) ou emulador

## Casos de Uso

O aplicativo possui os seguintes casos de uso:

1. **Obter notícias**: O aplicativo consome a News API para obter notícias recentes e exibi-las em uma lista. As notícias são carregadas de forma assíncrona e exibidas na tela principal do aplicativo.

2. **Salvar notícias**: Os usuários podem salvar suas notícias favoritas para acessá-las posteriormente. Ao exibir uma notícia, o usuário pode marcar a notícia como favorita e ela será armazenada localmente usando a biblioteca Room.

3. **Obter notícias salvas**: Os usuários podem acessar uma lista de suas notícias favoritas salvas. Essas notícias são carregadas localmente do banco de dados usando a biblioteca Room e exibidas em uma tela separada.

4. **Remover notícias salvas**: Os usuários podem remover notícias previamente salvas da lista de favoritos. Ao visualizar uma notícia salva, o usuário pode optar por removê-la e ela será excluída do banco de dados.

5. **Pesquisar notícias**: Os usuários podem pesquisar notícias específicas usando palavras-chave. O aplicativo permite que os usuários insiram termos de pesquisa e exibe os resultados correspondentes da API de notícias.


## Tecnologias:

- [**Retrofit**](https://square.github.io/retrofit/): Uma biblioteca de cliente HTTP para Android que simplifica o consumo de APIs RESTful. O Retrofit é utilizado para realizar as chamadas à News API e obter os dados das notícias.

- [**News API**](https://newsapi.org/): Uma API de notícias que fornece acesso a uma grande variedade de fontes e artigos de notícias. O aplicativo consome essa API para obter as notícias recentes e exibi-las aos usuários.

- [**Room**](https://developer.android.com/jetpack/androidx/releases/room?hl=pt-br): Uma biblioteca de persistência do Android que oferece uma camada de abstração sobre o SQLite. O Room é utilizado para salvar as notícias favoritas localmente no dispositivo dos usuários, permitindo que eles acessem essas notícias mesmo offline.

- [**MockWebServer**](https://github.com/square/okhttp/tree/master/mockwebserver): Uma biblioteca de teste que simula um servidor HTTP para testes de integração. O MockWebServer é utilizado para fornecer respostas simuladas durante os testes unitários, garantindo que o aplicativo se comunique corretamente com a API de notícias.

- [**ViewModels**](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=pt-br): Os View Models são uma parte do padrão de arquitetura do Android (Android Architecture Components) e são responsáveis por gerenciar e fornecer dados às interfaces de usuário. Eles são utilizados para separar a lógica de negócio da interface de usuário no aplicativo.

- [**Navigation**](https://developer.android.com/guide/navigation?hl=pt-br): O Navigation é um componente da biblioteca de arquitetura do Android que facilita a navegação entre diferentes destinos (telas) em um aplicativo. Ele é utilizado para gerenciar a navegação entre as diferentes telas do aplicativo de forma estruturada.

- [**Dagger Hilt**](https://dagger.dev/hilt/): O Dagger Hilt é um framework de injeção de dependência para o desenvolvimento de aplicativos Android. Ele simplifica a configuração e o gerenciamento das dependências no aplicativo, tornando-o mais modular e fácil de manter.

- [**DiffUtil**](https://developer.android.com/reference/androidx/recyclerview/widget/DiffUtil): O DiffUtil é uma classe que ajuda a calcular as diferenças entre duas listas de dados, permitindo atualizações eficientes na RecyclerView ao adicionar, remover ou modificar itens.

- [**WebView**](https://developer.android.com/reference/android/webkit/WebView): O WebView é um componente do Android que permite exibir conteúdo da web dentro do aplicativo. Ele é utilizado para carregar e exibir as notícias completas quando os usuários selecionam uma notícia específica para ler.


## Configuração
Siga as etapas abaixo para configurar o projeto em seu ambiente local:

1. Clone o repositório do projeto:

```
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

2. Abra o projeto no Android Studio.

3. Aguarde até que o Android Studio sincronize o projeto e baixe as dependências necessárias.

4. Execute o aplicativo em um dispositivo Android conectado ou em um emulador.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE). Sinta-se à vontade para usar, modificar e distribuir este código