pipeline {
    agent any
    tools{
        maven 'M3'
    }
    stages {
        stage('Build jar') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh ' docker build -t gitlab.advenio.com.ar:5050/advenio/medere/medereemr:1.46-jenkins-test .'
                }
            }
        }
        stage('Docker Login to gitlab'){
            steps{
                 script{
                    withCredentials([string(credentialsId: 'username-', variable: 'username'), string(credentialsId: 'password-', variable: 'password')]) {
                        sh 'docker login gitlab.advenio.com.ar:5050 --username ${username} --password ${password}'
                    }
                 }
            }
        }
        stage('Push image to Gitlab'){
            steps{
                script{
                    sh 'docker push gitlab.advenio.com.ar:5050/advenio/medere/medereemr:1.46-jenkins-test'
                }
            }
        }
    }
}