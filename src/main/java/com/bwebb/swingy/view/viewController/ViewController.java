package com.bwebb.swingy.view.viewController;

import com.bwebb.swingy.view.terminal.TerminalView;

public class ViewController {
    TerminalView terminal = new TerminalView();
    private int terminalSelector;
    private int guiSelector = 1;

    public void mainMenu(int view) {
        if (view == terminalSelector)
            terminal.terminalMainMenu();
    }

    public void hype(int view) {
        if (view == terminalSelector)
            terminal.hype();
    }
}
