pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Limpar e compilar o projeto usando Maven
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Executar os testes do projeto
                    sh 'mvn test'
                }
            }
        }
    }
}
