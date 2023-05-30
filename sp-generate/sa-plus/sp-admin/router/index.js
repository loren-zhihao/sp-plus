// 定义菜单列表
var menuList =	[
	{
		name: 'category',
		path: '/category',
		component: Layout,
        meta: {
          title: '密码分类表',
          icon: 'el-icon-folder-opened'
        },
		childList: [
            {
                name: 'category-list',
                path: 'category-list',
                component: () => import('@/sp-views/category/category-list.vue'),
                meta: { title: '密码分类表-列表' }
            },
            {
                name: 'category-add',
                path: 'category-add',
                component: () => import('@/sp-views/category/category-add.vue'),
                meta: { title: '密码分类表-新增' }
            },
            {
                name: 'category-info',
                path: 'category-info',
                component: () => import('@/sp-views/category/category-info.vue'),
                meta: { title: '密码分类表-详情' }
            },
		]
	},
	{
		name: 'password',
		path: '/password',
		component: Layout,
        meta: {
          title: '密码表',
          icon: 'el-icon-folder-opened'
        },
		childList: [
            {
                name: 'password-list',
                path: 'password-list',
                component: () => import('@/sp-views/password/password-list.vue'),
                meta: { title: '密码表-列表' }
            },
            {
                name: 'password-add',
                path: 'password-add',
                component: () => import('@/sp-views/password/password-add.vue'),
                meta: { title: '密码表-新增' }
            },
            {
                name: 'password-info',
                path: 'password-info',
                component: () => import('@/sp-views/password/password-info.vue'),
                meta: { title: '密码表-详情' }
            },
		]
	},
]