pipelineJob('test-pg-job') {
  description('test pg ')
  logRotator(5,5)
  parameters {
    choiceParam('action',['Launch','Destroy'],'')
	nonStoredPasswordParam('myParameterName', 'my description')
  }
  definition {
    cps {
        script(readFileFromWorkspace('pipeline/test.groovy'))
        sandbox()
    }
  }

}