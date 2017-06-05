package aop.last_anno_example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by artmaster on 02.06.2017.
 */
@Aspect
public class MyAdvice {

    @Pointcut("execution(* aop.last_anno_example..foo*(int)) && args(intValue))")
    public void fooExecution(int intValue) { }

    @Pointcut("bean(myDependency*)")
    public void inMyDependency() {

    }

    @Before(value = "fooExecution(intValue) && inMyDependency()", argNames = "joinPoint,intValue")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
        if (intValue != 100)
            System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName()
                    + joinPoint.getSignature().getName() + "argument: " + intValue);
    }

    @Around(value = "fooExecution(intValue) && inMyDependency()", argNames = "proceedingJoinPoint,intValue")
    public Object simpleAroundAdvice(ProceedingJoinPoint proceedingJoinPoint, int intValue) throws Throwable {
        System.out.println("Before execution: " + proceedingJoinPoint.getSignature().getDeclaringTypeName() +
        " " + proceedingJoinPoint.getSignature().getName()
        + " argument: " + intValue);

        Object retVal = proceedingJoinPoint.proceed();

        System.out.println("After execution: " +
        proceedingJoinPoint.getSignature().getDeclaringTypeName() + " "
        + " argument: " + intValue);
        return retVal;
    }
}
