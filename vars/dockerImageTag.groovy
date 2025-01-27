def call(String imageTag, String imageName, int buildNumber) {
    sh "docker tag ${imageTag} ${imageName}:v${buildNumber}"
    sh "docker tag ${imageTag} ${imageName}:latest"
}
