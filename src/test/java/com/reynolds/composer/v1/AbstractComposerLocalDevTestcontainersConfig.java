package com.reynolds.composer.v1;

import org.testcontainers.containers.GenericContainer;

public abstract class AbstractComposerLocalDevTestcontainersConfig {

    private final static long MEMORY_LIMIT_MEGABYTES = 256;
    private final static long MEMORY_LIMIT_BYTES = MEMORY_LIMIT_MEGABYTES * 1_000_000;

    protected void configureContainer(GenericContainer<?> container) {
        container.withCreateContainerCmdModifier(cmd -> {
            cmd.getHostConfig()
                    .withCpusetCpus("1")
                    .withMemory(MEMORY_LIMIT_BYTES);
        });;
    }
}
