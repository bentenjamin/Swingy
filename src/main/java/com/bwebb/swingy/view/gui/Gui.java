package com.bwebb.swingy.view.gui;

import com.bwebb.swingy.controller.GameController;
import com.bwebb.swingy.model.chars.charClasses.ClassesHandler;
import com.bwebb.swingy.model.chars.player.Character;
import com.bwebb.swingy.model.map.Coordinates;
import com.bwebb.swingy.view.DisplayStringHandler;
import com.bwebb.swingy.view.ViewInterface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ViewInterface {
    private final GameController controller;
    private final DisplayStringHandler stringHandler;

    private JPanel panel;

    //stuff
    JTextPane txtpnTextoutput = new JTextPane();
    private final JTextPane txtpnDisplay = new JTextPane();

    //generic
    JButton btnQuit = new JButton("Quit");
    JButton btnBack = new JButton("Back");
    JButton btnOption1 = new JButton();
    JButton btnOption2 = new JButton();
	Font monoFontExplore = new Font(Font.MONOSPACED, 3, 30);
	Font monoFontGeneric = new Font(Font.MONOSPACED, 3, 10);
	JButton btnReturn = new JButton("Return to Menu");
	JComboBox<String> saveList = new JComboBox<String>();
	JButton btnChooseSelected = new JButton();


	//menu
    JButton btnDelete = new JButton("Delete");
    JButton btnMenuLoad = new JButton("Load");
    JTextArea menuTitle = new JTextArea();
    JButton btnCreateCharacter = new JButton("Create Character");

    //createCharacter
    JComboBox<String> classes = new JComboBox<String>();
    JButton btnCreate = new JButton("Create");
    JTextPane txtpnCreateChar = new JTextPane();

    //exploring
    JTextPane mapDisplay = new JTextPane();
    JButton btnStats = new JButton("Stats");
    JButton btnUp = new JButton("Up");
    JButton btnDown = new JButton("Down");
    JButton btnLeft = new JButton("Left");
    JButton btnRight = new JButton("Right");

	//delete save
	JButton btnDelAll = new JButton("Delete All");


    /**
     * Create the frame.
     */
    public Gui(GameController controller, DisplayStringHandler strHandler) {
        this.controller = controller;
        stringHandler = strHandler;

        initComponents();

//		exploring(2, 2 ,2);
    }

    private void initComponents() {
        //default things
        setTitle("Swingy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1018, 726);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout(0, 0));
        setContentPane(panel);
        panel.setLayout(null);



        //generic
		//buttons
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand("q");
            }
        });
        btnQuit.setBounds(36, 375, 166, 33);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand("b");
            }
        });
        btnBack.setBounds(36, 330, 166, 33);

		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("menu");
			}
		});
		btnReturn.setBounds(36, 368, 166, 33);

		btnOption1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("1");
			}
		});
		btnOption1.setBounds(36, 285, 166, 33);

		btnOption2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("2");
			}
		});
		btnOption2.setBounds(36, 330, 166, 33);

		btnChooseSelected.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand(Integer.toString((saveList.getSelectedIndex() + 1)));
			}
		});
		btnChooseSelected.setBounds(36, 285, 166, 33);

		//generic text output for exploring state
        txtpnTextoutput.setEditable(false);
        txtpnTextoutput.setBounds(746, 227, 166, 195);

        //text display
//		txtpnDisplay.setBounds(36, 31, 316, 193);
		txtpnDisplay.setFont(monoFontGeneric);

		//saveList
		saveList.setBounds(36, 12, 166, 33);


        //menu
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand("3");
            }
        });
        btnDelete.setBounds(36, 330, 166, 33);

        btnMenuLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand("2");
            }
        });
        btnMenuLoad.setBounds(36, 285, 166, 33);

        btnCreateCharacter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand("1");
            }
        });
        btnCreateCharacter.setBounds(36, 240, 166, 33);

        menuTitle.setEditable(false);
        menuTitle.setText(" ________  ___       __   ___  ________   ________      ___    ___ \n|\\   ____\\|\\  \\     |\\  \\|\\  \\|\\   ___  \\|\\   ____\\    |\\  \\  /  /|\n\\ \\  \\___|\\ \\  \\    \\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\___|    \\ \\  \\/  / /\n \\ \\_____  \\ \\  \\  __\\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\  ___   \\ \\    / / \n  \\|____|\\  \\ \\  \\|\\__\\_\\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\|\\  \\   \\/  /  /  \n    ____\\_\\  \\ \\____________\\ \\__\\ \\__\\\\ \\__\\ \\_______\\__/  / /    \n   |\\_________\\|____________|\\|__|\\|__| \\|__|\\|_______|\\___/ /     \n   \\|_________|                                       \\|___|/      \n\nwell its supposed to say Swingy :(");
        menuTitle.setBounds(36, 12, 436, 185);



        //createCharacter
        classes.setBounds(53, 45, 149, 24);
        String[] classList = ClassesHandler.getClassList();
        for (String aClass : classList)
            classes.addItem(aClass);
        classes.setSelectedIndex(0);

        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand(Integer.toString((classes.getSelectedIndex() + 1)));
            }
        });
        btnCreate.setBounds(36, 271, 166, 33);

        txtpnCreateChar.setText("Create Character");
        txtpnCreateChar.setBounds(49, 12, 153, 21);



        //exploring
        mapDisplay.setBounds(45, 28, 612, 571);
        mapDisplay.setEditable(false);
        mapDisplay.setFont(monoFontExplore);

        btnStats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                controller.runGuiCommand("i");
            }
        });
        btnStats.setBounds(774, 507, 117, 25);

		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("w");
			}
		});
		btnUp.setBounds(774, 28, 117, 25);

		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("s");
			}
		});
		btnDown.setBounds(774, 102, 117, 25);

		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("a");
			}
		});
		btnLeft.setBounds(669, 65, 117, 25);

		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("d");
			}
		});
		btnRight.setBounds(858, 65, 117, 25);



		//delete save
		btnDelAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.runGuiCommand("d");
			}
		});
		btnDelAll.setBounds(36, 240, 166, 33);
	}

    public void mainMenu() {
        panel.removeAll();

        panel.add(btnCreateCharacter);
        panel.add(menuTitle);
        panel.add(btnMenuLoad);
        panel.add(btnDelete);
        panel.add(btnQuit);

        panel.repaint();
    }

    @Override
    public void invalidInput() {
    }

    @Override
    public void endScreen() {
    }

    @Override
    public void createCharacter() {
        panel.removeAll();

        panel.add(classes);
        panel.add(btnQuit);
        panel.add(btnBack);
        panel.add(btnCreate);
        panel.add(txtpnCreateChar);

        panel.repaint();
    }

    @Override
    public void exploring(int[][] mapArr, Coordinates playerPos) {
        panel.removeAll();

        mapDisplay.setText(stringHandler.arrMapToCenteredStrMap(mapArr, playerPos));

        panel.add(mapDisplay);
        panel.add(txtpnTextoutput);
		panel.add(btnQuit);
		panel.add(btnStats);
		panel.add(btnUp);
		panel.add(btnDown);
		panel.add(btnLeft);
		panel.add(btnRight);

        panel.repaint();
    }

    @Override
    public void exploring(int[][] curMap) {
    }

    @Override
    public void loadingPlayer() {
    }

    @Override
    public void blockage() {
        txtpnTextoutput.setText(stringHandler.genBlockage());
    }

    private void genericTwoOption(String display, String btn1, String btn2) {
		panel.removeAll();

		txtpnDisplay.setText(display);
		txtpnDisplay.setBounds(36, 31, 316, 193);

		btnOption1.setText(btn1);
		btnOption2.setText(btn2);

		panel.add(txtpnDisplay);
		panel.add(btnOption1);
		panel.add(btnOption2);

		panel.repaint();
	}

    @Override
    public void artifactFound(String artifactType, int newArtifactStat, int currentArtifactStat) {
		String message = stringHandler.artifactString(artifactType, newArtifactStat, currentArtifactStat);
		genericTwoOption(message, "Equip", "Drop");
    }

    @Override
    public void enemyFound() {
    	String message = "You have encountered an enemy!\nDo you Fight or attempt to Flee?";
    	genericTwoOption(message, "Fight", "Flee");
    }

	@Override
	public void askSave() {
		String message = "Do you want to save?";
		genericTwoOption(message, "Save", "No");
	}

    @Override
    public void fight() {
        txtpnTextoutput.setText("You engage in an 'epic battle that will be spoke of for decades'");
    }

    @Override
    public void fightWon() {
        txtpnTextoutput.setText("You have slain the heretic");
    }

    @Override
    public void fled() {
        txtpnTextoutput.setText("You have evaded the Monster");
    }

    @Override
    public void equippedArtifact() {
        txtpnTextoutput.setText("You have equipped your new loot");
    }

    @Override
    public void levelUp(int playerLevel) {
        txtpnTextoutput.setText("You have leveled up to level " + playerLevel);
    }

    private void messageToMenu(String message) {
		panel.removeAll();

		txtpnDisplay.setBounds(36, 31, 316, 193);
		txtpnDisplay.setText(message);

		panel.add(txtpnDisplay);
		panel.add(btnReturn);

		panel.repaint();
	}

    @Override
	public void death() {
		messageToMenu("YOU DIED");
	}

	@Override
    public void win() {
		messageToMenu("MISSION SUCCESS");
    }

    @Override
    public void stats(Character player) {
        txtpnTextoutput.setText(stringHandler.formatStats(player));
    }

    private void viewSaves(String[] savedNamesList, String button) {
		panel.removeAll();

		if (savedNamesList.length >= 0) {
			saveList.removeAllItems();
			for (String save : savedNamesList)
				saveList.addItem(save);
			saveList.setSelectedIndex(0);
			btnChooseSelected.setText(button);
			panel.add(saveList);
			panel.add(btnChooseSelected);
		}

		panel.add(btnBack);
		panel.add(btnQuit);

		panel.repaint();
	}

    @Override
	public void loadPlayer(String[] savedNamesList) {
		viewSaves(savedNamesList, "Load");
	}

    @Override
    public void deleteSaves(String[] savesList) {
		viewSaves(savesList, "Delete");
		panel.add(btnDelAll);
    }
}
