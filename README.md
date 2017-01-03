* Inspired by the [Little Tortoise language](https://eclipse.org/Xtext/documentation/208_tortoise.html), I have created a simple DSL project that shows how you can extend the [XBaseInterpreter](http://download.eclipse.org/modeling/tmf/xtext/javadoc/2.9/org/eclipse/xtext/xbase/interpreter/impl/XbaseInterpreter.html) class. The language allows you to define expressions and on-save of the editor the expressions are executed by the interpreter, and result is displatyed in the Eclipse console.
* The following files should interest you - [ProgramInterpreter.xtend](https://github.com/nbhusare/Xbase-sandbox/blob/master/org.ne.xtext.example.program/src/org/ne/xtext/example/program/interpreter/ProgramInterpreter.xtend) and [ProgramDocumentProvider.xtend](https://github.com/nbhusare/Xbase-sandbox/blob/master/org.ne.xtext.example.program.ui/bin/org/ne/xtext/example/program/ui/documentprovider/ProgramDocumentProvider.xtend), [ProgramDslJvmModelInferrer.xtend](https://github.com/nbhusare/Xbase-sandbox/blob/master/org.ne.xtext.example.program/bin/org/ne/xtext/example/program/jvmmodel/ProgramDslJvmModelInferrer.xtend).
