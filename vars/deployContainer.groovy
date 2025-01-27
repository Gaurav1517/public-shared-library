def call(String imageName, String jobNameLower) {
    sh "docker run -d --name ${jobNameLower} -p 3000:3000 ${imageName}:latest"
}
