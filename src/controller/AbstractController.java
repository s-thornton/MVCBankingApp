package controller;

import model.Model;
import view.View;
//Generalized Controller for getting and setting Model and View Classes
public abstract class AbstractController implements Controller{
    private View view;
    private Model model;

    public void setModel(Model model) { this.model = model; }
    public Model getModel() { return model; }
    public View getView() { return view; }
    public void setView(View view) { this.view = view; }
}
