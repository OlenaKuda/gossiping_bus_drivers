package katas.gossiping_drivers;

import katas.data.BusDriver;

import java.util.List;

public interface AbstractCommand<TInput, TOutput> {
    TOutput execute(TInput input);
}
