# Genesis
Totoe ([Maori for "to split, devide"](http://www.maoridictionary.co.nz/index.cfm?dictionaryKeywords=totoe)) is a XML parser for GWT. Totoe comes with [JSONPath](http://www.sitepen.com/blog/2008/03/17/jsonpath-support/) support when parsing JSON and XPath and namespace support when parsing XML. It originated from [Pirit](https://github.com/hpehl/piriti) a JSON and XML mapper for GWT.

## JSON
Totoe uses [JSONPath](http://www.sitepen.com/blog/2008/03/17/jsonpath-support/) to evaluate JSONPath expressions. 

## XML 
For the XML parsing Totoe relies on [Sarissa](http://dev.abiss.gr/sarissa/). Sarissa is a great cross browser XML parser for javascript. Essentially Totoe is a GWT port of Sarissa with the goal to offer a similar API as the GWT XML module. Right now the focus is on parsing XML - there are no methods to create, insert or append documents, elements or nodes. Those features might come in later releases. The big advantage over the GWT XML module is IMHO a cleaner API and the support of XPath and namespaces. 

## Features / Limitations
  * Support for [JSONPath](http://www.sitepen.com/blog/2008/03/17/jsonpath-support/) expressions
  * XML parser with similar API as the GWT XML module
  * Support for XPath
  * Namespaces support in IE7 and IE8
  * Right now no support to create, insert or append documents, elements or nodes.

## Totoe-Tester
If you want to take a quick look at Totoes features feel free to go to http://totoe-tester.appspot.com/. There you can enter arbitrary JSON / XML and test your XPath / JSONPath expressions.
