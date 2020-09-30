package com.bwebb.swingy.view;

import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.controller.views;
import com.bwebb.swingy.view.gui.Gui;
import com.bwebb.swingy.view.terminal.TerminalView;

import java.io.IOException;

public class viewController {
    private GameController controller;

    public ViewInterface display = null;
    private Gui guiView;
    private TerminalView terminalView;
    protected DisplayStringHandler strHandler = new DisplayStringHandler();

    public viewController(GameController controller) {
        this.controller = controller;
        guiView = new Gui(controller, strHandler);
        terminalView = new TerminalView(strHandler);
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

    public Gui getGuiView() {
        return guiView;
    }
}
