import groovy.json.JsonSlurperClassic
import groovy.json.JsonOutput


node() {
  sh "echo ganga"
  sh "echo $myParameterName"
}