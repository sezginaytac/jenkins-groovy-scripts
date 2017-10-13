import hudson.model.*

def printViewFn = printJobFn = { v, depth ->
  println("".padRight(depth*2) + v.name)
}

def dfsViews(node, depth, visitViewFn, visitJobFn) {
  for(v in node.getViews()) {
    def clazz = v.getClass().getName()
    //println( "$v.name - $clazz")
    visitViewFn(v, depth)
  
    if (v instanceof hudson.plugins.nested_view.NestedView) {
      dfsViews(v, depth+1, visitViewFn, visitJobFn)
    } else if (v instanceof hudson.model.ListView) {
      for(j in v.getItems()) {
        visitJobFn(j, depth+1)
      }
    }
  }
}

dfsViews(Hudson.instance, 0, printViewFn, printJobFn)
