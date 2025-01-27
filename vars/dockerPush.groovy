def call() {
    script {
        withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
            sh "docker login -u ${docker_user} -p ${docker_pass}"
            sh "docker push ${IMAGE_NAME}:v${BUILD_NUMBER}"
            sh "docker push ${IMAGE_NAME}:latest"
        }
    }
}
