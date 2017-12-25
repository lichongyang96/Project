import java.util.Iterator;
import java.util.List;

import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.Block;
import soot.toolkits.graph.BlockGraph;
import soot.toolkits.graph.BriefBlockGraph;
import soot.toolkits.graph.BriefUnitGraph;
import soot.toolkits.graph.ExceptionalGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.cfgcmd.CFGToDotGraph;
import soot.util.dot.DotGraph;


public class Generate{
	public static void main(String[] args){
		final String path1 = "E:/java/Test/src";
		//final String paht2 = "TriangleClass.Triangle";
		final String paht2 = "symbol.TestFor";
		
		String path = Scene.v().getSootClassPath();
		if (path != null){
			Scene.v().setSootClassPath(path + ".;" + path1);
		}
		SootClass the_class = Scene.v().loadClassAndSupport(paht2);
		the_class.setApplicationClass();
		List<SootMethod> methods = the_class.getMethods();
		
		for (int i = 0; i < methods.size(); i++){
			SootMethod method = methods.get(i);
			if (method.getName().equals("test")){
				Body body = method.retrieveActiveBody();
				UnitGraph graph = new BriefUnitGraph(body);
				//BlockGraph graph = new BriefBlockGraph(body);
				//CFGToDotGraph drawer = new CFGToDotGraph();
				DotGraph drawer = new CFGToDotGraph().drawCFG(graph, body);
				drawer.plot("E:/java/Test/symbol_for_out2.dot");
			}
		}
	}
}
