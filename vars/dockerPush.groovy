// def call(String imageName, String buildNumber) {
//     withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
//         sh "docker login -u ${docker_user} -p ${docker_pass}"
//         sh "docker push ${imageName}:${buildNumber}"
//         sh "docker push ${imageName}:latest"
//     }
// }

def call(String imageName, String buildNumber) {
    // Validate image name and build number            
    if (!imageName?.trim() || !buildNumber?.trim()) {
        error "Invalid image name or build number: ${imageName}:${buildNumber}"
    }

    withCredentials([usernamePassword(credentialsId: 'dockerHub-cred', passwordVariable: 'docker_pass', usernameVariable: 'docker_user')]) {
        // Log in to Docker Hub
        sh "echo ${docker_pass} | docker login -u ${docker_user} --password-stdin"
        
        // Correct Docker push commands
       // sh "docker push ${imageName}:${buildNumber}"  // Push the versioned image (e.g., starbucks:v2)
        sh "docker push ${imageName}:latest"  // Push the 'latest' tag
    }
}
