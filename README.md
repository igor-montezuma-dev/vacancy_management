# Vacancy Management

## Descrição

Esta é uma aplicação Spring Boot desenvolvida para gerenciar empresas, candidatos e vagas de emprego. Ela oferece um conjunto de funcionalidades para facilitar o processo de recrutamento e seleção, permitindo o cadastro de empresas, candidatos e vagas de forma organizada e segura.

## Funcionalidades

1. **Cadastro de Empresa:** Permite registrar informações detalhadas sobre empresas, incluindo nome, descrição, setor, localização, entre outros.
2. **Cadastro de Candidato:** Oferece a capacidade de cadastrar candidatos interessados em oportunidades de emprego, incluindo dados como nome, experiência, habilidades, currículo, etc.
3. **Cadastro de Vaga:** Permite criar vagas de emprego especificando requisitos, responsabilidades, benefícios, etc.

## Implementações na API

A API desta aplicação inclui diversas implementações para garantir a segurança e o correto funcionamento do sistema:

1. **Spring Security**: Foi utilizado o Spring Security para proteger as rotas da API. Ele oferece autenticação e autorização baseadas em papel (role-based), garantindo que apenas usuários autenticados e autorizados tenham acesso aos recursos protegidos.
2. **Tokens JWT (JSON Web Tokens)**: Foi implementado o uso de tokens JWT para autenticar usuários. Após o login bem-sucedido, um token JWT é gerado e enviado ao cliente, que deve incluí-lo em todas as solicitações subsequentes para acessar recursos protegidos.
3. **Validação de Acesso**: A validação de acesso é feita em cada requisição, verificando se o token JWT é válido e se o usuário possui permissões adequadas para acessar o recurso solicitado. Em caso de falha na validação, uma resposta de erro é retornada.
