"""
 This script traverses the sites tree - change it to do whatever you want to do :)

Standalone scripts have no template.
They are only evaluated when you run them.
""" 

from org.parosproxy.paros.model import Model

def listChildren(node, level):
  indent = "".join("    " for _ in range(level))
  for j in range(node.getChildCount()):
    print(indent + node.getChildAt(j).getNodeName())
    listChildren(node.getChildAt(j), level+1)

root = Model.getSingleton().getSession().getSiteTree().getRoot();

listChildren(root, 0);


