package katas.gossiping_busdrivers.logic;

public interface AbstractExecutor<TInput, TOutput> {
    TOutput execute(TInput input);
}
