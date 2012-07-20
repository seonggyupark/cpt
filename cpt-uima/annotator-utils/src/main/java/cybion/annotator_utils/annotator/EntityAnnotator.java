package cybion.annotator_utils.annotator;

import java.util.ArrayList;
import java.util.Collection;

import cybion.annotator_utils.jcas.cas.Entity;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.tcas.Annotation;

public abstract class EntityAnnotator extends JCasAnnotator_ImplBase {

    private Collection<Entity> entities = new ArrayList<Entity>();

    public Collection<Entity> getEntities() {
        return entities;
    }

    public void setEntities(Collection<Entity> entities) {
        this.entities = entities;
    }


    /**
     * adds the annotation reference to the right entity
     */
    protected void addEntityReference(JCas cas, Annotation annotation) {

        boolean newEntity = true;
        for (Entity entity : this.getEntities()) {
            //if the annotation covers the same text of the entity then add annotation to the occurencies of the entity
            if (entity != null && entity.getText().equals(annotation.getCoveredText())) {
                newEntity = false;
                FSArray arr = entity.getOccurencies(); //get current occurencies

                //create an array based on already present occurrencies then add the last annotation to it
                FSArray updatedOccurencies = new FSArray(cas, arr.size() + 1);
                updatedOccurencies.copyFromArray(arr.toArray(), 0, 0, arr.size());
                updatedOccurencies.set(arr.size(), annotation);

                entity.setOccurencies(updatedOccurencies); //set the new occurencies for the entity

                break;
            }
        }
        //if the annotation does not match any entity text create a new entity with that text
        if (newEntity) {
            Entity newUE = new Entity(cas);
            newUE.setText(annotation.getCoveredText());
            FSArray fsArr = new FSArray(cas, 1);
            fsArr.set(0, annotation);
            newUE.setOccurencies(fsArr);
            newUE.addToIndexes();
            this.getEntities().add(newUE);
        }

    }


}

	