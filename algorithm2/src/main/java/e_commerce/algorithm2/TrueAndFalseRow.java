package e_commerce.algorithm2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueAndFalseRow extends TrueAndFalse{

	private static final Logger logger = LoggerFactory.getLogger(TrueAndFalseRow.class);

	public TrueAndFalseRow(List<Boolean> result) {
		super(result);
	}

	@Override
	public int getCountOfItem() {
		return this.result.size();
	}
}
