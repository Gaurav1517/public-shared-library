def call(String imageName) {
    withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
        sh "docker login -u ${docker_user} -p ${docker_pass}"
        sh "docker-scout quickview ${imageName}:latest"
        sh "docker-scout cves ${imageName}:latest"
        sh "docker-scout recommendations ${imageName}:latest"
    }
}
