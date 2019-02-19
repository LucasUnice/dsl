from matplotlib.figure import Figure
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg


windowSize = 20

class GraphComponent:
    def __init__(self,master,name,color):
        self.fig = Figure(figsize=(5,4), dpi = 80)

        self.sub = self.fig.add_subplot(111)
        self.sub.set_title(name)
        self.xdata = []
        self.ydata = []
        line, = self.sub.plot([], [],'g',color=color, marker='o', linestyle='dashed',linewidth=0, markersize=1)
        self.sub.set_ylim(-0.1,1.1)
        self.sub.set_xlim(0,windowSize)
        self.line = line
        self.fig.axes[0].set_xlabel('time(s)')
        self.fig.axes[0].set_ylabel('value')
        self.canvas = FigureCanvasTkAgg(self.fig, master=master)
        self.canvas.draw()

    def getWidget(self):
            return self.canvas.get_tk_widget()

    def update(self,data):

        self.ydata.extend(data[1])
        self.xdata.extend(data[0])

        if len(self.xdata) > len(self.ydata):
            self.xdata = self.xdata[0:len(self.ydata)]
        else :
            self.ydata = self.ydata[0:len(self.xdata)]


        maxlim = self.xdata[len(self.xdata)-1] if self.xdata[len(self.xdata)-1] > windowSize else windowSize
        lowerlim = maxlim-windowSize if maxlim > windowSize else 0
        self.sub.set_xlim(lowerlim,maxlim)


        self.line.set_xdata(self.xdata)
        self.line.set_ydata(self.ydata)
        self.canvas.draw()


    @staticmethod
    def name():
        return 'graph'
