# GS2_2025_RM550120 - Android Kotlin Developer

## Global Solution - 2º Semestre de 2025

Este projeto foi desenvolvido como parte da Global Solution (GS) do 2º Semestre de 2025 para a disciplina de Android Kotlin Developer.

### Objetivo
O objetivo do projeto é criar um aplicativo Android nativo utilizando **Kotlin** e **Jetpack Compose** que implemente as seguintes funcionalidades:
1.  Tela de Login com validação de credenciais.
2.  Tela de Menu com opções de navegação.
3.  Tela de Cálculo de IMC (Índice de Massa Corporal).
4.  Tela de Equipe com os dados dos integrantes.

### Integrantes da Equipe
| Nome Completo | RM |
| :--- | :--- |
| Dimitris Tzirnazoglou Assis Lopes | RM550120 |
| João Vitor Nava | RM98623 |

### Funcionalidades Implementadas

#### 1. Tela de Login
- **Usuário:** `admin`
- **Senha:** `123456`
- **Validação:** Em caso de erro, exibe a mensagem "Usuário inválido".
- **Navegação:** Redireciona para a Tela de Menu em caso de sucesso.

*(Captura de tela da Tela de Login será adicionada aqui)*

#### 2. Tela de Menu
- Permite a navegação para as telas de "Cálculo de IMC" e "Equipe".
- Possui um botão "Voltar" que realiza o logout e retorna para a Tela de Login.

*(Captura de tela da Tela de Menu será adicionada aqui)*

#### 3. Tela de Cálculo de IMC
- Permite a entrada do nome, peso (kg) e altura (m).
- Calcula o IMC e exibe o resultado formatado, juntamente com a classificação e o nome da pessoa.

*(Captura de tela da Tela de Cálculo de IMC será adicionada aqui)*

#### 4. Tela de Equipe
- Exibe o nome e o RM dos integrantes da equipe.
- Possui um botão para retornar à Tela de Menu.

*(Captura de tela da Tela de Equipe será adicionada aqui)*

### Estrutura do Projeto
O projeto segue a arquitetura de componentes do Jetpack Compose com navegação utilizando `NavHost`.

**Pacote Principal:** `com.example.gs2_2025_rm550120`
- `MainActivity.kt`: Configuração principal e `NavHost` para navegação.
- `ui.screens/`: Contém os composables de cada tela (`LoginScreen.kt`, `MenuScreen.kt`, `IMCScreen.kt`, `TeamScreen.kt`).
- `ui.theme/`: Contém os arquivos de tema, cores e tipografia.

### Como Executar
1.  Clone o repositório.
2.  Abra o projeto no Android Studio.
3.  Sincronize o Gradle.
4.  Execute o aplicativo em um emulador ou dispositivo físico.
