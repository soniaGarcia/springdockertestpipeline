node {
  stage('build & deploy') {
    openshiftBuild bldCfg: 'testpod',
      namespace: 'testpod',
      showBuildLogs: 'true'
    openshiftVerifyDeployment depCfg: 'testpod',
      namespace: 'testpod'
  }
}
