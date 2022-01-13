package elf;

import enums.Elf;

public class ElfFactory {
    public static ElfStrategy createElf (Elf elf) {
        return switch (elf) {
            case WHITE -> new WhiteElfStrategy();
            case BLACK -> new BlackElfStrategy();
            case YELLOW -> new YellowElfStrategy();
            case PINK -> new PinkElfStrategy();
        };
    }
}
