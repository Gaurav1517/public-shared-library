def call(String imageName, int buildNumber, String dockerUsername) {
    sh """
        docker tag ${imageName}:${buildNumber} ${dockerUsername}/${imageName}:v${buildNumber}
        docker tag ${imageName}:${buildNumber} ${dockerUsername}/${imageName}:latest
    """
}
