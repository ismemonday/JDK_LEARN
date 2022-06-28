package mao.gui.dong.design23.component;

import java.util.ArrayList;

/**
 * @author maoguidong
 */
public class Composite extends Component {
    private ArrayList<Component> children=new ArrayList<Component>();

    @Override
    public void add(Component component){
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        super.remove(component);
    }

    @Override
    public Component getChildren(int i){
        return children.get(i);
    }

    @Override
    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}
