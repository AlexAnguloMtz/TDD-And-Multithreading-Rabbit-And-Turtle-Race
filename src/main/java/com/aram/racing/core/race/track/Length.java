package com.aram.racing.core.race.track;

import com.aram.racing.assertions.Assert;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static java.util.Objects.requireNonNull;

@Getter
@EqualsAndHashCode
@ToString
public final class Length {
    private final int measure;
    private final UnitOfLength unitOfLength;

    private Length(int measure, UnitOfLength unitOfLength) {
        Assert.IsGreater(measure, 0, "Length can't be negative");
        this.measure = measure;
        this.unitOfLength = requireNonNull(unitOfLength, "Length needs a unit of length");
    }

    public static Length of(int amount, UnitOfLength unit) {
        return new Length(amount, unit);
    }

}
