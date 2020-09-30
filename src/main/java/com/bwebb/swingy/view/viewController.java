package com.bwebb.swingy.view;

import com.bwebb.swingy.controller.GameAssets;
import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.controller.views;
import com.bwebb.swingy.view.gui.Gui;
import com.bwebb.swingy.view.terminal.TerminalView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class viewController {
    private GameAssets game;
    private GameController controller;

    public ViewInterface display = null;
    private Gui guiView;
    private TerminalView terminalView;

    public viewController(GameController controller) {
        this.controller = controller;
        guiView = new Gui(controller);
        terminalView = new TerminalView();
    }

    public void setDisplay(views view) throws IOException {
        switch (view) {
            case GUI -> switchGui();
            default -> switchToTerminal();
        }
    }

    private void switchGui() {
        display = guiView;
        guiView.setVisible(true);
        controller.getGame().state.printMe();
    }

    private void switchToTerminal() throws IOException {
        guiView.setVisible(false);
        display = terminalView;
        controller.readConsole();
    }
}
