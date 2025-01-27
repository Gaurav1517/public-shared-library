def call(String imageName, String buildNumber) {
    withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
        sh "docker login -u ${docker_user} -p ${docker_pass}"
        sh "docker push ${imageName}:${buildNumber}"
        sh "docker push ${imageName}:latest"
    }
}
