node { 
    stage('GIT-FETCH') {
        git 'https://github.com/anverma007/ToDo-Management.git'
    }
    stage('MAVEN-BUILD'){
        sh label: '', script: 'docker build . -t anverma007/todo-management'
    }
    stage('PUSH TO DOCKERHUB'){
         sh label: '', script: 'docker login -u anverma007 -p Narayan@007'
         sh label: '', script: 'docker push anverma007/todo-management'
    }
    stage('PULL FROM DOCKERHUB'){
         sh label: '', script: 'docker pull anverma007/todo-management'
    }
    stage('RUNNING A CONTAINER'){
         sh label: '', script: 'docker run -dp 8888:8081 --name todo-management anverma007/todo-management'
    }
}
