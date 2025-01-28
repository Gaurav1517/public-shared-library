def call(String imageName) {
    def imageTag = "${BUILD_NUMBER}"
    withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
        sh "echo ${docker_pass} | docker login -u ${docker_user} --password-stdin"
        sh "docker-scout quickview ${imageName}:${imageTag}"
        sh "docker-scout cves ${imageName}:${imageTag}"
        sh "docker-scout recommendations ${imageName}:${imageTag}"
    }
}

