def call() {
    // Build the Docker image
    sh "docker build -t ${IMAGE_TAG} ."
}
