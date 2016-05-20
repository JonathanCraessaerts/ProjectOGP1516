package hillbillies.model;

import java.util.ArrayList;
import java.util.List;

public class statSequence extends Statements {
	
	protected statSequence(List<Statements> statements) throws IllegalArgumentException{
		if (! isValidStatements(statements))
			throw new IllegalArgumentException();
		setSeq(this.seq);
	}

	public Statements getIndex(int i){
		return seq.get(i);
	}
	
	public int seqLength(){
		return seq.size();
	}
	
	public void addToSequence(Statements stat){
		seq.add(stat);	
	}
	public void removeFromSequence(Statements stat){
		assert seq.contains(stat);
		seq.remove(stat);	
	}
	
	
	public List< Statements> getSeq(){
		return this.seq;
	}
	

	public void setSeq(List<Statements> seq){
		this.seq = seq;
	}
	
	private List<Statements> seq = new ArrayList<Statements>();
}
