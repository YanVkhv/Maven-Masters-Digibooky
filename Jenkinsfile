pipeline {
    agent any

    tools {
        jdk 'jdk-11'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
    }
}
