pipeline {
    agent any
  stages{
      stage('Git Checkout') {
          steps{
              git 'https://github.com/anverma007/ToDo-Management.git'
          }
      }
      stage('Maven Clean') {
          steps{
              sh 'mvn clean'
          }      
      }
      stage('Maven Test') {
          steps{
              sh 'mvn test'
          }
      }
      stage('Maven Package') {
          steps{
              sh 'mvn package'
          }
      }
      stage('SonarQube analysis') {
          steps{
              withSonarQubeEnv(credentialsId: 'efe906d7-7632-4c94-a2f6-b75adfeaa158', installationName: 'sonar2') { 
                  sh 'mvn sonar:sonar'
            }
          }
      }
      stage('Defining Artifactory Server') {
          steps{
              script {
                  rtServer (
                        'id' : 'Artifactory-1',
                        'url' : 'http://miwyz7473dns.eastus2.cloudapp.azure.com:8081/artifactory',
                        'username' : 'admin',
                        'password' : 'password'
                    )
              }
          }
      }
      stage('Deploying artifacts to Artifactory Server') {
          steps{
              script {
                  rtUpload (
                        'serverId' : 'Artifactory-1',
                        'spec' : '''{
                              "files": [
                                {
                                  "pattern": "**/*.jar",
                                  "target": "example-repo-local"
                                }
                             ]
                        }'''
                    )
              }
          }
      }
      
      stage('Create Docker-Image') {
          steps{
              sh label: '', script: 'docker build . -t anverma007/todo-management'
          }
      }
      stage('Pushing to Docker-Hub'){
          steps{
              sh label: '', script: 'docker login -u anverma007 -p Narayan@007'
              sh label: '', script: 'docker push anverma007/todo-management'
          }
      }
      stage('Pulling from Docker-Hub'){
          steps{
              sh label: '', script: 'docker pull anverma007/todo-management'
          }
      }
      stage('Running the Application'){
          steps{
              sh label: '', script: 'docker run -dp 8009:8081 --name todo-management anverma007/todo-management'
          }
      }
  }
    
}
