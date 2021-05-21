package com.nepxion.discovery.platform.server.state.context;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.statemachine.StateMachine;

import com.nepxion.discovery.platform.server.state.enums.Events;
import com.nepxion.discovery.platform.server.state.enums.States;

public class StateMachineContext {
    private static final ThreadLocal<StateMachineContext> THREAD_LOCAL = new ThreadLocal<StateMachineContext>() {
        @Override
        protected StateMachineContext initialValue() {
            return new StateMachineContext();
        }
    };

    private StateMachine<States, Events> stateMachine;

    public static StateMachineContext getCurrentContext() {
        return THREAD_LOCAL.get();
    }

    public static void clearCurrentContext() {
        THREAD_LOCAL.remove();
    }

    public StateMachine<States, Events> getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}