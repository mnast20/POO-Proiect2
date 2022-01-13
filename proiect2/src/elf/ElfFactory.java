package elf;

import enums.Elf;

public final class ElfFactory {
    private ElfFactory() {
    }

    /**
     * Method creating and returning an elf strategy based on a given elf type
     */
    public static ElfStrategy createElf(final Elf elf) {
        return switch (elf) {
            case WHITE -> new WhiteElfStrategy();
            case BLACK -> new BlackElfStrategy();
            case YELLOW -> new YellowElfStrategy();
            case PINK -> new PinkElfStrategy();
        };
    }
}
