def call() {
    return this
}

def docker_push(String credID, String imageName)
{
               withCredentials([usernamePassword(
                    credentialsId:"${credID}",
                    usernameVariable:"dockerhubName",
                    passwordVariable:"dockerhubPass"
                    )]){
                sh "docker login -u ${env.dockerhubName} -p ${env.dockerhubPass}"
                sh "docker tag ${imageName} ${env.dockerhubName}/${imageName}"
                sh "docker push ${env.dockerhubName}/${imageName}:latest"
}
