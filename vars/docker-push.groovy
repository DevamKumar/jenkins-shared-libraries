def call(String Project, String ImageTag, String dockeruser){
  withCredentials([usernamePassword( credentialsId: 'docker-credentials-id', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    sh '''
    #!/bin/bash
    echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
    docker push ${REGISTRY}:${IMAGE_TAG}
    '''
  }
}
