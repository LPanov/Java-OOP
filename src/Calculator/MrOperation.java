package Calculator;

import java.util.ArrayList;
import java.util.List;

public class MrOperation implements Operation{
    private List<Integer> operands;
    private MsOperation msOperation;
    private int result;

    public MrOperation(MsOperation operation){
        this.msOperation = operation;
        this.operands = new ArrayList<>();
    }

    public MsOperation getMsOperation() {
        return msOperation;
    }

    @Override
    public void addOperand(int operand) {
        operands.add(getMsOperation().getResult());

        if (getMsOperation().isCompleted()) {
            this.result = getMsOperation().getResult();
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() >= 1;
    }
}

