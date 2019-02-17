from matplotlib.figure import Figure
from tkinter import *
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from GraphComponent import GraphComponent

class Display:
    def __init__(self, configs):
        self.window = Tk()
        self.window.geometry("1280x720")
        panel = PanedWindow(self.window, orient=VERTICAL)

        self.modPanel = PanedWindow(panel,orient=HORIZONTAL)
        self.modPanel.add(Label(master=self.modPanel,text="Current mode"))
        self.currentMod = StringVar()
        self.modPanel.add(Label(master=self.modPanel,textvariable=self.currentMod))
        self.modPanel.pack()
        panel.add(self.modPanel)

        self.statePanel = PanedWindow(panel,orient=HORIZONTAL)
        self.statePanel.add(Label(master=self.statePanel,text="Current state"))
        self.currentState = StringVar()
        self.statePanel.add(Label(master=self.statePanel,textvariable=self.currentState))
        self.statePanel.pack()
        panel.add(self.statePanel)

        self.components = dict()
        graphPanel = PanedWindow(panel, orient=HORIZONTAL)
        for sensor in configs["watchables"]:
            component = GraphComponent(graphPanel,sensor)
            self.components[sensor] = component
            graphPanel.add(component.getWidget(),width=400,height = 320)

        graphPanel.pack()
        panel.add(graphPanel)
        panel.pack()

    def init(self,data, refreshFrequence):
        self.window.after(refreshFrequence,self.update, data,refreshFrequence)
        self.window.mainloop()



    def update(self,data, freq):
        try:
            self.currentMod.set(data['mode'])
            self.currentState.set(data['state'])
            for component in self.components:
                self.components[component].update(data['sensors'][component])

            self.window.after(freq,self.update,data,freq)
        except:
            self.window.after(freq,self.update,data,freq)

