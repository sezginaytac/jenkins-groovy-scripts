import hudson.model.*

def printJobFn = {println it.name}

def search(searchCriteria, visitJobFn) {
  //println searchCriteria.class.name
  
  items = Hudson.instance.getItems()
  
  if (searchCriteria instanceof String) {
    items.findAll{ job -> 
      job.name =~ searchCriteria || job.name.contains(searchCriteria)}
    .each {visitJobFn(it)}
  } else if (searchCriteria instanceof ArrayList) {
    items.findAll{ job -> searchCriteria.every{job.name.contains(it)} }.each {visitJobFn(it)}
  }
  println("")
}
