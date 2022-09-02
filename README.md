# qingyi-tp

qingyi ===> 清一|清伊     tp ===> threadPool

动态线程池项目；学习大佬代码，从零开始写

原项目：[dynamic-tp](https://github.com/dromara/dynamic-tp)

### 1.第一步：加载配置文件中配置的ThreadPoolExecutor对象到Spring容器中

####1.自定义启动类注解 @EnableQingyiTP

####2.Import类QytpBeanDefinitionRegistrar

####3.核心逻辑如下

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //从environment对象中获取threadPoolExecutor相关配置
        QingyiTPProterties qingyiTPProterties = new QingyiTPProterties();
        Binder binder = Binder.get(environment);
        ResolvableType resolvableType = ResolvableType.forClass(QingyiTPProterties.class);
        Bindable<Object> target = Bindable.of(resolvableType).withExistingValue(qingyiTPProterties);
        binder.bind(QytpConstant.MAIN_PROPERTITY_PREFIX, target);

        if (CollectionUtils.isEmpty(qingyiTPProterties.getExecutors())) {
            log.warn("qingyi-tp executors is empty");
            return;
        }

        //解析配置为BeanDifinition信息，通过BeanDefinitionRegistry注册到spring容器中
        for (ThreadPoolProterties executor : qingyiTPProterties.getExecutors()) {
            if (registry.containsBeanDefinition(executor.getThreadPoolName())) {
                log.error("has alread exist executorName:{}", executor.getThreadPoolName());
                continue;
            }

            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(QytpExecutor.class);

            //构建线程池参数
            Object[] args = {
                    executor.getCorePoolSize(),
                    executor.getMaximumPoolSize(),
                    executor.getKeepAliveTime(),
                    TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(1000),
                    (ThreadFactory) r -> new Thread(QytpConstant.MAIN_PROPERTITY_PREFIX)
            };
            for (Object arg : args) {
                builder.addConstructorArgValue(arg);
            }

            //绑定配置文件中的属性
            Map<String, Object> propertiesMap = new HashMap() {{
                put(QytpConstant.THREAD_POOL_NAME, executor.getThreadPoolName());
            }};
            propertiesMap.forEach(builder::addPropertyValue);

            //注册到spring容器中
            registry.registerBeanDefinition(executor.getThreadPoolName(), builder.getBeanDefinition());
        }
    }