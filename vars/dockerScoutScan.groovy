def call() {
    script {
        withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
            sh "docker login -u ${docker_user} -p ${docker_pass}"
            sh "docker-scout quickview ${IMAGE_NAME}:latest"
            sh "docker-scout cves ${IMAGE_NAME}:latest"
            sh "docker-scout recommendations ${IMAGE_NAME}:latest"
        }
    }
}
