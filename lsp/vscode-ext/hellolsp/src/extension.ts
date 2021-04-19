"use strict";

// The module 'vscode' contains the VS Code extensibility API
// Import the module and reference it with the alias vscode in your code below
import { Trace } from "vscode-jsonrpc";
import * as vscode from "vscode";
import * as net from "net";
import {
  LanguageClient,
  LanguageClientOptions,
  StreamInfo,
  Position as LSPosition,
  Location as LSLocation,
} from "vscode-languageclient/node";

export function activate(context: vscode.ExtensionContext) {
  console.log('Activating "hellolsp" extension!');

  let connectionInfo = {
    port: 5007,
  };
  let serverOptions = () => {
    // Connect to language server via socket
    let socket = net.connect(connectionInfo);
    let result: StreamInfo = {
      writer: socket,
      reader: socket,
    };
    return Promise.resolve(result);
  };

  let clientOptions: LanguageClientOptions = {
    documentSelector: ["mydsl"],
    synchronize: {
      fileEvents: vscode.workspace.createFileSystemWatcher("**/*.*"),
    },
  };

  // Create the language client and start the client.
  let lc = new LanguageClient("Xtext Server", serverOptions, clientOptions);
  lc.trace = Trace.Verbose;
  let disposable = lc.start();

  // Push the disposable to the context's subscriptions so that the
  // client can be deactivated on extension deactivation
  context.subscriptions.push(disposable);

  vscode.window.showInformationMessage("Hello World from hellolsp!");
}

// this method is called when your extension is deactivated
export function deactivate() {}
