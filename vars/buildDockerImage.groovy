def call(String imageName, String buildNumber) {
    sh "docker build -t ${imageName}:${buildNumber} ."
}
